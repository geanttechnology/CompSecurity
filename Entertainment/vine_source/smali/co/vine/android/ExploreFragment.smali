.class public Lco/vine/android/ExploreFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "ExploreFragment.java"

# interfaces
.implements Lco/vine/android/widget/OnTabChangedListener;
.implements Lcom/twitter/android/widget/TopScrollable;
.implements Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;
    }
.end annotation


# static fields
.field public static final ARG_TAKE_FOCUS:Ljava/lang/String; = "take_focus"

.field private static final LOGGABLE:Z

.field private static final PARAM_EDITION:Ljava/lang/String; = "ed"

.field private static final PARAM_MODEL:Ljava/lang/String; = "model"

.field private static final PARAM_OS:Ljava/lang/String; = "os"

.field private static final PARAM_VERSION:Ljava/lang/String; = "v"

.field private static final PREF_LAST_REFRESH_TIME:Ljava/lang/String; = "last_explore"

.field private static final REFRESH_INTERVAL:J = 0xdbba0L

.field private static final TAG:Ljava/lang/String; = "ExploreFragment"

.field private static final VALUE_OS:Ljava/lang/String; = "android"

.field private static final VALUE_UNDEFINED:Ljava/lang/String; = "undefined"


# instance fields
.field private mConnectivityReceiver:Landroid/content/BroadcastReceiver;

.field private mEmpty:Landroid/view/View;

.field private mEmptyText:Landroid/widget/TextView;

.field private mExploreUrl:Ljava/lang/String;

.field private mPrefs:Landroid/content/SharedPreferences;

.field private mProgressContainer:Landroid/widget/RelativeLayout;

.field private mSadface:Landroid/widget/ImageView;

.field private mSadfaceContainer:Landroid/view/View;

.field private mWebView:Landroid/webkit/WebView;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 67
    const-string v0, "ExploreFragment"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Lco/vine/android/ExploreFragment;->LOGGABLE:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 79
    new-instance v0, Lco/vine/android/ExploreFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/ExploreFragment$1;-><init>(Lco/vine/android/ExploreFragment;)V

    iput-object v0, p0, Lco/vine/android/ExploreFragment;->mConnectivityReceiver:Landroid/content/BroadcastReceiver;

    .line 232
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ExploreFragment;)Landroid/widget/RelativeLayout;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lco/vine/android/ExploreFragment;->mProgressContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/ExploreFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lco/vine/android/ExploreFragment;->mEmpty:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/ExploreFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lco/vine/android/ExploreFragment;->mSadface:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/ExploreFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lco/vine/android/ExploreFragment;->mSadfaceContainer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/ExploreFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ExploreFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lco/vine/android/ExploreFragment;->mEmptyText:Landroid/widget/TextView;

    return-object v0
.end method

.method private getExploreUrl()Ljava/lang/String;
    .locals 9

    .prologue
    .line 178
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lco/vine/android/util/Util;->getVersionName(Landroid/content/Context;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 185
    .local v3, "versionName":Ljava/lang/String;
    :goto_0
    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v5, "%s_%s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    sget-object v8, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    sget-object v8, Landroid/os/Build;->MODEL:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 187
    .local v1, "model":Ljava/lang/String;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 189
    .local v0, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "model"

    const-string v6, "\\s+"

    const-string v7, "-"

    invoke-virtual {v1, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 190
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "v"

    invoke-direct {v4, v5, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 191
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "os"

    const-string v6, "android"

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 192
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "ed"

    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/provider/SettingsManager;->getEdition(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 194
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lco/vine/android/ExploreFragment;->mExploreUrl:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "?"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "UTF-8"

    invoke-static {v0, v5}, Lorg/apache/http/client/utils/URLEncodedUtils;->format(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 180
    .end local v0    # "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v1    # "model":Ljava/lang/String;
    .end local v3    # "versionName":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 181
    .local v2, "nnfe":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v3, "undefined"

    .restart local v3    # "versionName":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 115
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 116
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/VineAPI;->getExploreUrl()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mExploreUrl:Ljava/lang/String;

    .line 117
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "take_focus"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 118
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/HomeTabActivity;

    .line 119
    .local v0, "callback":Lco/vine/android/HomeTabActivity;
    const/4 v1, 0x2

    invoke-virtual {v0, v1, p0}, Lco/vine/android/HomeTabActivity;->showPage(ILandroid/support/v4/app/Fragment;)V

    .line 120
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 121
    const-string v1, "ExploreFragment"

    const-string v2, "Explore tab took focus."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    .end local v0    # "callback":Lco/vine/android/HomeTabActivity;
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->reloadWebView()V

    .line 125
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 95
    const v1, 0x7f030039

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 96
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0a00e2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mEmpty:Landroid/view/View;

    .line 97
    const v1, 0x7f0a007f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mEmptyText:Landroid/widget/TextView;

    .line 98
    const v1, 0x7f0a00c5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mProgressContainer:Landroid/widget/RelativeLayout;

    .line 99
    const v1, 0x7f0a007e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mSadfaceContainer:Landroid/view/View;

    .line 100
    const v1, 0x7f0a00e3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mSadface:Landroid/widget/ImageView;

    .line 101
    const v1, 0x7f0a00e1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/webkit/WebView;

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    .line 102
    const v1, 0x7f0a00e4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    new-instance v2, Lco/vine/android/ExploreFragment$2;

    invoke-direct {v2, p0}, Lco/vine/android/ExploreFragment$2;-><init>(Lco/vine/android/ExploreFragment;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    const v1, 0x7f0a00e0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/widget/ScrollDeltaScrollView;

    invoke-virtual {v1, p0}, Lco/vine/android/widget/ScrollDeltaScrollView;->setScrollDeltaListener(Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;)V

    .line 109
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/ExploreFragment;->mPrefs:Landroid/content/SharedPreferences;

    .line 110
    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 294
    iget-object v1, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 295
    .local v0, "parent":Landroid/view/ViewGroup;
    iget-object v1, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeViewAt(I)V

    .line 296
    iget-object v1, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->destroy()V

    .line 297
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onDestroy()V

    .line 298
    return-void
.end method

.method public onMoveAway(I)V
    .locals 0
    .param p1, "newPosition"    # I

    .prologue
    .line 200
    return-void
.end method

.method public onMoveTo(I)V
    .locals 9
    .param p1, "oldPosition"    # I

    .prologue
    const-wide/16 v7, 0x0

    .line 204
    iget-object v5, p0, Lco/vine/android/ExploreFragment;->mPrefs:Landroid/content/SharedPreferences;

    const-string v6, "last_explore"

    invoke-interface {v5, v6, v7, v8}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    .line 205
    .local v1, "lastTime":J
    iget-object v5, p0, Lco/vine/android/ExploreFragment;->mPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 206
    .local v0, "edit":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 207
    .local v3, "now":J
    if-eqz v0, :cond_0

    .line 208
    cmp-long v5, v1, v7

    if-lez v5, :cond_1

    const-wide/32 v5, 0xdbba0

    add-long/2addr v5, v1

    cmp-long v5, v5, v3

    if-gez v5, :cond_1

    .line 209
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->reloadWebView()V

    .line 210
    const-string v5, "last_explore"

    invoke-interface {v0, v5, v3, v4}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 215
    :cond_0
    :goto_0
    return-void

    .line 211
    :cond_1
    cmp-long v5, v1, v7

    if-gtz v5, :cond_0

    .line 212
    const-string v5, "last_explore"

    invoke-interface {v0, v5, v3, v4}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 138
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onPause()V

    .line 139
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/ExploreFragment;->mConnectivityReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 140
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    .line 129
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 130
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 131
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 132
    const-string v1, "abort_all_requests"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 133
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ExploreFragment;->mConnectivityReceiver:Landroid/content/BroadcastReceiver;

    const-string v3, "co.vine.android.BROADCAST"

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 134
    return-void
.end method

.method public onScroll(I)V
    .locals 1
    .param p1, "delta"    # I

    .prologue
    .line 229
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/HomeTabActivity;

    invoke-virtual {v0, p1}, Lco/vine/android/HomeTabActivity;->onScroll(I)V

    .line 230
    return-void
.end method

.method public reloadWebView()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 143
    iget-object v5, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    .line 144
    .local v5, "webView":Landroid/webkit/WebView;
    if-eqz v5, :cond_3

    .line 145
    invoke-virtual {v5, v8}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 146
    iget-object v6, p0, Lco/vine/android/ExploreFragment;->mSadfaceContainer:Landroid/view/View;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/view/View;->setVisibility(I)V

    .line 147
    new-instance v6, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;

    invoke-direct {v6, p0}, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;-><init>(Lco/vine/android/ExploreFragment;)V

    invoke-virtual {v5, v6}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 148
    invoke-virtual {v5, v8}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 149
    invoke-virtual {v5}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v4

    .line 151
    .local v4, "s":Landroid/webkit/WebSettings;
    const/4 v6, 0x1

    :try_start_0
    invoke-virtual {v4, v6}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 155
    :goto_0
    const/4 v6, 0x2

    invoke-virtual {v4, v6}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 156
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2, v9}, Ljava/util/HashMap;-><init>(I)V

    .line 157
    .local v2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Lco/vine/android/util/Util;->getLocale()Ljava/lang/String;

    move-result-object v3

    .line 158
    .local v3, "language":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 159
    const-string v6, "Accept-Language"

    invoke-interface {v2, v6, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v0

    .line 162
    .local v0, "api":Lco/vine/android/client/VineAPI;
    const-string v6, "X-Vine-Client"

    invoke-virtual {v0}, Lco/vine/android/client/VineAPI;->getVineClientHeader()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isProduction()Z

    move-result v6

    if-nez v6, :cond_1

    .line 164
    const-string v6, "X-Vine-Auth"

    invoke-virtual {v0}, Lco/vine/android/client/VineAPI;->getAuthHeaderSecret()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 166
    :cond_1
    invoke-direct {p0}, Lco/vine/android/ExploreFragment;->getExploreUrl()Ljava/lang/String;

    move-result-object v1

    .line 167
    .local v1, "exploreUrl":Ljava/lang/String;
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 168
    const-string v6, "ExploreFragment"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Accessing explore url: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 170
    :cond_2
    invoke-virtual {v5, v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    .line 172
    .end local v0    # "api":Lco/vine/android/client/VineAPI;
    .end local v1    # "exploreUrl":Ljava/lang/String;
    .end local v2    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "language":Ljava/lang/String;
    .end local v4    # "s":Landroid/webkit/WebSettings;
    :cond_3
    return-void

    .line 152
    .restart local v4    # "s":Landroid/webkit/WebSettings;
    :catch_0
    move-exception v6

    goto :goto_0
.end method

.method public scrollTop()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 219
    iget-object v1, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    if-eqz v1, :cond_0

    .line 220
    iget-object v1, p0, Lco/vine/android/ExploreFragment;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1, v0, v0}, Landroid/webkit/WebView;->scrollTo(II)V

    .line 221
    const/4 v0, 0x1

    .line 223
    :cond_0
    return v0
.end method
