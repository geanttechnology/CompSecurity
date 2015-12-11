.class Lcom/aio/downloader/activity/MyMainActivity$29;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/AboutCustomDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/AboutCustomDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$29;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$29;->val$dialog:Lcom/aio/downloader/dialog/AboutCustomDialog;

    .line 2644
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 2648
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$29;->val$dialog:Lcom/aio/downloader/dialog/AboutCustomDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/AboutCustomDialog;->dismiss()V

    .line 2650
    return-void
.end method
