import java.net.URL
import java.io.InputStream

object SpeedTest {
    def main(args: Array[String]) = {
        val is: InputStream = new URL("https://raw.githubusercontent.com/EvgenyKazban/testfile/main/20MB-TESTFILE.ORG.pdf").openStream()
        val bs = Array.ofDim[Byte](1024)
        val ct = System.currentTimeMillis()
        var bytesRead = is.read(bs)
        
        while(bytesRead != -1 && System.currentTimeMillis() < (ct + 1000)) {
          bytesRead += is.read(bs)
        }
        
        is.close()
        
        print(s"$bytesRead bytes per second")
    }
}
