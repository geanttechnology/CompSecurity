.class Lcom/aio/downloader/cleaner/PhoneBoostActivity$8;
.super Ljava/lang/Object;
.source "PhoneBoostActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/PhoneBoostActivity;->showNorma()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$8;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 465
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 470
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$8;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_stop:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$14(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/Button;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 471
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$8;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->bt_clean:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$15(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 473
    return-void
.end method
