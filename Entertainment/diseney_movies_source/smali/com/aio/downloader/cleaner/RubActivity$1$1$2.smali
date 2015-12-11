.class Lcom/aio/downloader/cleaner/RubActivity$1$1$2;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity$1$1;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

.field private final synthetic val$dialog1:Lcom/aio/downloader/dialog/CleanerDialog1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity$1$1;Lcom/aio/downloader/dialog/CleanerDialog1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$2;->this$2:Lcom/aio/downloader/cleaner/RubActivity$1$1;

    iput-object p2, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$2;->val$dialog1:Lcom/aio/downloader/dialog/CleanerDialog1;

    .line 202
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 205
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$1$1$2;->val$dialog1:Lcom/aio/downloader/dialog/CleanerDialog1;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/CleanerDialog1;->dismiss()V

    .line 206
    return-void
.end method
