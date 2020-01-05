package lab;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.Html;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HtmlUnitDemo {
    public static void main(String[] args) throws IOException {
        //无界面的浏览器
        WebClient webClient=new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        HtmlPage page=webClient.getPage("https://so.gushiwen.org/gushi/tangshi.aspx");
        System.out.println(page);
        //page.save(new File("唐诗三百首\\列表页.html"));
        File file=new File("唐诗三百首\\列表页.html");
        page.save(file);

        HtmlElement body=page.getBody();
        List<HtmlElement> elements=body.getElementsByAttribute("div","class","typecont");
        for(HtmlElement element:elements){
            System.out.println(element);
        }

        HtmlElement divElement=elements.get(0);
        List<HtmlElement> aElements=divElement.getElementsByAttribute("a","target","_blank");
        for(HtmlElement e:aElements){
            System.out.println(e);
        }
        System.out.println(aElements.size());
        //System.out.println(aElements.get(0));
    }
}
