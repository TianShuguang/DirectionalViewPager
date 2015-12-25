# DirectionalViewPager
支持横向和纵向的ViewPager


  当使用Jake Whartons 的 [Android-DirectionalViewPager](https://github.com/JakeWharton/Android-DirectionalViewPager)的时候，会遇到会提示 ClassNotFound，找不到这个DataSetObserver类，
  是因为DataSetObserver 已经在 /frameworks/base/core/java/android/database/DataSetObserver.java 定义了 

  本例子中重新修改了代码，可正常运行。

具体项目介绍，可移步：[Android-DirectionalViewPager](https://github.com/JakeWharton/Android-DirectionalViewPager)

### 改动的地方  
 ```Java
    import android.database.DataSetObserver;
```
```Java
    private class PagerDataSetObserver extends DataSetObserver {

        @Override
        public void onChanged() {
            dataSetChanged();
        }

        @Override
        public void onInvalidated() {
            dataSetChanged();
        }
    }
 ```
 ```Java
    private PagerDataSetObserver mObserver;
 ```
    
```Java
    public void setAdapter(PagerAdapter adapter) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mObserver);
        }

        mAdapter = adapter;

        if (mAdapter != null) {
            if (mObserver == null) {
                mObserver = new PagerDataSetObserver();
            }
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            if (mRestoredCurItem >= 0) {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } else {
                populate();
            }
        }
    }
```
