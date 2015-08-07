# SimpleRecyclerViewAnimator

Well, this is a simple animation example about RecyclerView.

I use [DefaultItemAnimator](https://android.googlesource.com/platform/frameworks/support/+/refs/heads/master/v7/recyclerview/src/android/support/v7/widget/DefaultItemAnimator.java) modification.

if you want to use change animator and move animator, you need to edit [BaseItemAnimator](https://github.com/Kuan-Wei-Kuo/SimpleRecyclerViewAnimator/blob/master/app/src/main/java/com/kuo/animator/BaseItemAnimator.java) code.

#How to use 

Step 1. Import the project

Step 2. Set RecyclerView Item Animator like this：

```recyclerView.setItemAnimator(new SlideInLeftAnimator());```

##if you want to setting new animator, you can to do...

Step 1. Extands [BaseItemAnimator](https://github.com/Kuan-Wei-Kuo/SimpleRecyclerViewAnimator/blob/master/app/src/main/java/com/kuo/animator/BaseItemAnimator.java), like [this](https://github.com/Kuan-Wei-Kuo/SimpleRecyclerViewAnimator/blob/master/app/src/main/java/com/kuo/animator/ScaleInAnimator.java).

Step 2. Edit Method, Use [ViewCompat](http://developer.android.com/reference/android/support/v4/view/ViewCompat.html)

***
```prepareAnimateRemove(RecyclerView.ViewHolder holder)```

  Prepare item translation in remove.
***

```setAnimateRemove(RecyclerView.ViewHolder holder)```

  Set item animator in remove.
***

```prepareAnimateAdd(RecyclerView.ViewHolder holder)```

  Prepare item translation in add.
***

```setAnimateAdd(RecyclerView.ViewHolder holder)```

  Set item animator in add.
***

#Video

[![Video](https://lh3.googleusercontent.com/kaAu9WJ9stE3X9ta0HaUozhLK3QJ57ipXo8_ipKuIjg=w852-h512-no)](https://youtu.be/3Y9oEKV9h4w)

#Reference Sources

[wasabeef/recyclerview-animators](https://github.com/wasabeef/recyclerview-animators)
