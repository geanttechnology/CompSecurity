.class Lcom/kochava/android/tracker/Feature$6$1;
.super Ljava/lang/Thread;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kochava/android/tracker/Feature$6;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/kochava/android/tracker/Feature$6;

.field private final synthetic val$adWebview:Landroid/webkit/WebView;

.field private final synthetic val$clickUrl:Ljava/lang/String;

.field private final synthetic val$context:Landroid/app/Activity;

.field private final synthetic val$fAdUrl:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/kochava/android/tracker/Feature$6;Landroid/webkit/WebView;Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$6$1;->this$1:Lcom/kochava/android/tracker/Feature$6;

    iput-object p2, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    iput-object p3, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$fAdUrl:Ljava/lang/String;

    iput-object p4, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$context:Landroid/app/Activity;

    iput-object p5, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$clickUrl:Ljava/lang/String;

    .line 2184
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 2191
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 2192
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 2193
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 2194
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    new-instance v1, Lcom/kochava/android/tracker/Feature$6$1$1;

    iget-object v2, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$context:Landroid/app/Activity;

    iget-object v3, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$clickUrl:Ljava/lang/String;

    invoke-direct {v1, p0, v2, v3}, Lcom/kochava/android/tracker/Feature$6$1$1;-><init>(Lcom/kochava/android/tracker/Feature$6$1;Landroid/app/Activity;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 2247
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 2249
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaAds"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Loading add "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$fAdUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2250
    :cond_0
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$adWebview:Landroid/webkit/WebView;

    iget-object v1, p0, Lcom/kochava/android/tracker/Feature$6$1;->val$fAdUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 2252
    return-void
.end method
