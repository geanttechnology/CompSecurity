.class Lcom/aio/downloader/activity/AnzhuangActivity$8;
.super Ljava/lang/Object;
.source "AnzhuangActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AnzhuangActivity;->Mydialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AnzhuangActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$8;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    .line 497
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 501
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 502
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity$8;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->finish()V

    .line 503
    return-void
.end method
