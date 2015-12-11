// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.view.View;
import com.groupon.callbacks.QandARequestCallback;
import com.groupon.http.Http;
import com.groupon.models.qadiscussions.QaDiscussionPaginationWrapper;
import java.util.ArrayList;
import java.util.List;

public class QaDiscussionsService
{

    private Context context;

    public QaDiscussionsService()
    {
    }

    private String getPostsUrl(String s)
    {
        return String.format("https:/deals/%s/posts?limit=0", new Object[] {
            s
        });
    }

    private String getQuestionsUrl(String s)
    {
        return String.format("https:/deals/%s/questions?limit=0", new Object[] {
            s
        });
    }

    public void getDiscussions(String s, QandARequestCallback qandarequestcallback)
    {
        s = getQuestionsUrl(s);
        ((Http)(new Http(com/groupon/models/qadiscussions/QaDiscussionPaginationWrapper, s, qandarequestcallback) {

            final QaDiscussionsService this$0;
            final QandARequestCallback val$callback;

            protected void onException(Exception exception)
            {
                super.onException(exception);
                if (callback != null)
                {
                    callback.onException(exception);
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                if (callback != null)
                {
                    callback.onFinally();
                }
            }

            protected void onSuccess(QaDiscussionPaginationWrapper qadiscussionpaginationwrapper)
                throws Exception
            {
                super.onSuccess(qadiscussionpaginationwrapper);
                if (callback != null)
                {
                    callback.onDiscussionsSuccess(qadiscussionpaginationwrapper);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((QaDiscussionPaginationWrapper)obj);
            }

            public void onUserCancelRetry()
            {
                super.onUserCancelRetry();
                if (callback != null)
                {
                    callback.onCancel();
                }
            }

            protected boolean shouldRetry()
            {
                return true;
            }

            
            {
                this$0 = QaDiscussionsService.this;
                callback = qandarequestcallback;
                super(final_context1, class1, s);
            }
        }).ignoreHttpErrors()).execute();
    }

    public void getPosts(String s, View view, QandARequestCallback qandarequestcallback)
    {
        s = getPostsUrl(s);
        ((Http)(new Http(com/groupon/models/Post$ListWrapper, s, qandarequestcallback) {

            final QaDiscussionsService this$0;
            final QandARequestCallback val$callback;

            protected void onException(Exception exception)
            {
                super.onException(exception);
                if (callback != null)
                {
                    callback.onException(exception);
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                if (callback != null)
                {
                    callback.onFinally();
                }
            }

            protected void onSuccess(com.groupon.models.Post.ListWrapper listwrapper)
                throws Exception
            {
                super.onSuccess(listwrapper);
                if (callback != null)
                {
                    (new ArrayList()).addAll(listwrapper.posts);
                    callback.onPostsSuccess(listwrapper.posts);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((com.groupon.models.Post.ListWrapper)obj);
            }

            public void onUserCancelRetry()
            {
                super.onUserCancelRetry();
                if (callback != null)
                {
                    callback.onCancel();
                }
            }

            protected boolean shouldRetry()
            {
                return true;
            }

            
            {
                this$0 = QaDiscussionsService.this;
                callback = qandarequestcallback;
                super(final_context1, class1, s);
            }
        }).progressView(view)).execute();
    }
}
