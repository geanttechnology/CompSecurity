.class Lcom/aio/downloader/activity/MyMainActivity$Mya1$2;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    .line 2814
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "arg0"    # Landroid/widget/CompoundButton;
    .param p2, "arg1"    # Z

    .prologue
    .line 2820
    if-eqz p2, :cond_0

    .line 2821
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/aio/downloader/activity/MyMainActivity;->callerD:Z

    .line 2825
    :goto_0
    return-void

    .line 2823
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1$2;->this$1:Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v0

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/aio/downloader/activity/MyMainActivity;->callerD:Z

    goto :goto_0
.end method
