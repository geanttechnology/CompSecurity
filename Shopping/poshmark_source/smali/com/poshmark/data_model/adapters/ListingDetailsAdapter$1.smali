.class Lcom/poshmark/data_model/adapters/ListingDetailsAdapter$1;
.super Ljava/lang/Object;
.source "ListingDetailsAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter$1;->this$0:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    iget-object v1, v0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->replyToComment(Ljava/lang/String;)V

    .line 80
    return-void
.end method
