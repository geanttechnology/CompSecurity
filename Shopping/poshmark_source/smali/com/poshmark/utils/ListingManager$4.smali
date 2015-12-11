.class Lcom/poshmark/utils/ListingManager$4;
.super Ljava/lang/Object;
.source "ListingManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ListingManager;->presentRetryAlert(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ListingManager;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ListingManager;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager$4;->this$0:Lcom/poshmark/utils/ListingManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    .line 253
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$4;->this$0:Lcom/poshmark/utils/ListingManager;

    # invokes: Lcom/poshmark/utils/ListingManager;->resumeUpload()V
    invoke-static {v0}, Lcom/poshmark/utils/ListingManager;->access$000(Lcom/poshmark/utils/ListingManager;)V

    .line 258
    :goto_0
    return-void

    .line 256
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$4;->this$0:Lcom/poshmark/utils/ListingManager;

    const/4 v1, 0x0

    iput v1, v0, Lcom/poshmark/utils/ListingManager;->currentSentImageIndex:I

    goto :goto_0
.end method
