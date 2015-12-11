.class Lcom/aio/downloader/activity/UnInstallActivity$8;
.super Ljava/lang/Object;
.source "UnInstallActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/UnInstallActivity;->Mydialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/UnInstallActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/UnInstallActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/UnInstallActivity$8;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    .line 479
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 483
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 484
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$8;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->finish()V

    .line 485
    return-void
.end method
