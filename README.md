# DraggerDemo<br><br>
试用以下三个库的Demo:<br>
compile 'com.github.ppamorim:dragger:1.2'<br>
compile 'com.github.ppamorim:prismview:0.3'<br>
compile'com.facebook.rebound:rebound:0.3.8'<br>
<br>
dragger是可以实现拖动Activity的视觉效果，也可以实现手势返回的功能。<br>
prismview是dragger的Fragment版。<br>
rebound是facebook的一个Android的物理和动画库，dragger就是用它来实现一些弹簧之类的动画效果。<br>

1.使用Dragger可以知道，Dragger内部必须有两个子View，而且其中一个必须为透明（id/shadow_view），另外一个就是显示我们的内容（id/drag_view）。
Windows和其中一个shadow_view都是透明的，拖动的就是drag_view，所以拖动drag_view时可以看到前面一个Activity，给用户的视觉效果就是拖动了整个Activity。<br>
2.DraggerView可以在xml配置拖动的方向，也可以在Java代码用draggerView.setDraggerPosition(DraggerPosition.TOP)方法设置<br>
![](https://raw.githubusercontent.com/ppamorim/Dragger/master/art/app_sample.gif)<br>
3.Prismview其实Dragger的Fragment版，但是有点失望，使用限制比较多，比如Demo中：要继承PrismActivity，作者Demo中是用FragmentViewItemAdapter把Fragment封装好
，然后用show(position)显示相应的Fragment，没有拖动的效果，只有过渡动画。而且继承PrismActivity之后，对Toolbar的属性使用也是有限制，会出现莫名的错误。<br>
![](https://raw.githubusercontent.com/ppamorim/PrismView/master/art/sample.gif)<br>
4.rebound使用比想象中简单，在监听中对View进行普通动画就可以显示物理阻尼效果，非常棒！<br>