.class Lcom/aio/downloader/activity/MyMainActivity$12;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/NointentDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/NointentDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$12;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$12;->val$dialog:Lcom/aio/downloader/dialog/NointentDialog;

    .line 1212
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 1216
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$12;->val$dialog:Lcom/aio/downloader/dialog/NointentDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/NointentDialog;->dismiss()V

    .line 1218
    return-void
.end method
