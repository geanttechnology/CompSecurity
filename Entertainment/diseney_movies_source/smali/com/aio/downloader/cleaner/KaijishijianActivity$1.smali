.class Lcom/aio/downloader/cleaner/KaijishijianActivity$1;
.super Ljava/lang/Object;
.source "KaijishijianActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/KaijishijianActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$1;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity$1;->this$0:Lcom/aio/downloader/cleaner/KaijishijianActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->finish()V

    .line 61
    return-void
.end method
