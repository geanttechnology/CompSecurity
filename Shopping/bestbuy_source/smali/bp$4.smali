.class Lbp$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lbp;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/LinearLayout;

.field final synthetic b:Lbp;


# direct methods
.method constructor <init>(Lbp;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lbp$4;->b:Lbp;

    iput-object p2, p0, Lbp$4;->a:Landroid/widget/LinearLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 193
    iget-object v0, p0, Lbp$4;->b:Lbp;

    invoke-virtual {v0}, Lbp;->c()Z

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 194
    iget-object v0, p0, Lbp$4;->b:Lbp;

    invoke-virtual {v0}, Lbp;->a()V

    .line 195
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 196
    const-string v1, "bb.prevPageLink"

    sget-object v2, Llu;->aI:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    const-string v1, "bb.callBB"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    sget-object v1, Llu;->aJ:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/adobe/mobile/Analytics;->trackState(Ljava/lang/String;Ljava/util/Map;)V

    .line 202
    :goto_0
    return-void

    .line 200
    :cond_0
    iget-object v0, p0, Lbp$4;->a:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    goto :goto_0
.end method
