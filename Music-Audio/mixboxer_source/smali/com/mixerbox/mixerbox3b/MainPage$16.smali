.class Lcom/mixerbox/mixerbox3b/MainPage$16;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1307
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/16 v2, 0x8

    .line 1310
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isReady:Z

    .line 1311
    sput-boolean v1, Lcom/mixerbox/mixerbox3b/MainPage;->isPageLoaded:Z

    .line 1312
    const-string v0, "http://static.mixerbox.com/yt_android.min.b.v7.html"

    .line 1313
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1314
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1315
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1316
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1317
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$16;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1318
    return-void
.end method
