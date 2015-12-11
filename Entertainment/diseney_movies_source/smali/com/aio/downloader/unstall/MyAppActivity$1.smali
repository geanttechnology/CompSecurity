.class Lcom/aio/downloader/unstall/MyAppActivity$1;
.super Ljava/lang/Object;
.source "MyAppActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/unstall/MyAppActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/unstall/MyAppActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/unstall/MyAppActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppActivity$1;->this$0:Lcom/aio/downloader/unstall/MyAppActivity;

    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppActivity$1;->this$0:Lcom/aio/downloader/unstall/MyAppActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/unstall/MyAppActivity;->finish()V

    .line 72
    return-void
.end method
