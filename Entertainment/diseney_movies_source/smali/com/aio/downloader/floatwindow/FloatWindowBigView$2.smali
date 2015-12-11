.class Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;
.super Ljava/lang/Object;
.source "FloatWindowBigView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/floatwindow/FloatWindowBigView;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/floatwindow/FloatWindowBigView;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowBigView;

    iput-object p2, p0, Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;->val$context:Landroid/content/Context;

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;->val$context:Landroid/content/Context;

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->removeBigWindow(Landroid/content/Context;)V

    .line 51
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;->val$context:Landroid/content/Context;

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->createSmallWindow(Landroid/content/Context;)V

    .line 52
    return-void
.end method
