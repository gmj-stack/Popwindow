# PopupWindow
自定义popupwindow,项目中经常用到弹窗,所以我对popUp进行了封装

提出基类Basepopupwindow加载布局，设置背景有无透明

示例代码
public class TestDialog extends BasePopUpWindow {

    public TestDialog(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        //mContext 父类中声明
        return LayoutInflater.from(mContext).inflate(R.layout.test, null);
    }

    @Override
    protected void initView() {
       //mView父类中声明
        View viewById = mView.findViewById(R.id.button5);
    }
}
这是最基本的使用方式，demo中提供了内容弹窗 ，列表，以及相对某个元素显示

重点说下PopWindowUtils这个类,有时候我们并不只是单纯的显示一个弹窗，有时候还涉及到交互操作，所以单独的显示内容是无法满足的。
在popwinddowutils这个类中，我们可以往布局中添加任意的布局和控件，比如 textview，edittext ,listview等。
   //textview 示范
AppCompatTextView appCompatTextView = new AppCompatTextView(this);                                                                       
appCompatTextView.setText("111111");                                                                                                     
  //edittext 示范
AppCompatEditText appCompatEditText = new AppCompatEditText(this);                                                                       
appCompatEditText.setText("11111111111");
   //listview示范
ListView listView = new ListView(this);                                                                                           
ArrayList<String> strings = new ArrayList<>();                                                                                           
for (int i = 0; i < 10; i++) {
      strings.add("" + i);
    }
 listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));
  
然后调用addview方法 将控件添加进去即可。
如果无法日常使用可自行扩展
        
        
        
        
        
        
        
        
        
