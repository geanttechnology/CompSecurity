.class Lcom/aio/downloader/activity/VideoActivity$5;
.super Ljava/lang/Object;
.source "VideoActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoActivity;->Mydialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$5;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    .line 579
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "arg1"    # I

    .prologue
    .line 583
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 584
    return-void
.end method
