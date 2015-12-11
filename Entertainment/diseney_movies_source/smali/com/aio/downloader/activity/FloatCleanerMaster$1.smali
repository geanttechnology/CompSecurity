.class Lcom/aio/downloader/activity/FloatCleanerMaster$1;
.super Ljava/lang/Object;
.source "FloatCleanerMaster.java"

# interfaces
.implements Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FloatCleanerMaster;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$1;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    .line 1192
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OnAngelChanged(I)V
    .locals 5
    .param p1, "angel"    # I

    .prologue
    .line 1197
    new-instance v0, Landroid/text/SpannableString;

    new-instance v1, Ljava/lang/StringBuilder;

    mul-int/lit8 v2, p1, 0x64

    div-int/lit16 v2, v2, 0x168

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "%"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1199
    .local v0, "span":Landroid/text/SpannableString;
    new-instance v1, Landroid/text/style/AbsoluteSizeSpan;

    const/16 v2, 0x23

    invoke-direct {v1, v2}, Landroid/text/style/AbsoluteSizeSpan;-><init>(I)V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    .line 1200
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v3

    const/16 v4, 0x21

    .line 1199
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1202
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$1;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->clear_count:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$0(Lcom/aio/downloader/activity/FloatCleanerMaster;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1203
    return-void
.end method
