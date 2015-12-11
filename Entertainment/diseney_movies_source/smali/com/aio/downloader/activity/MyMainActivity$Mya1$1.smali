.class Lcom/aio/downloader/activity/MyMainActivity$Mya1$1;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$Mya1;->onPostExecute(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

.field private final synthetic val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;Lcom/aio/downloader/dialog/WebFirstDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$1;->val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;

    .line 2802
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 2807
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$1;->val$dialog1:Lcom/aio/downloader/dialog/WebFirstDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/WebFirstDialog;->dismiss()V

    .line 2808
    return-void
.end method
