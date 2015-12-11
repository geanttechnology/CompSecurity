.class Ldz$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldz;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lmw;

.field final synthetic b:Ldz;


# direct methods
.method constructor <init>(Ldz;Lmw;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Ldz$4;->b:Ldz;

    iput-object p2, p0, Ldz$4;->a:Lmw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Ldz$4;->b:Ldz;

    invoke-static {v0}, Ldz;->a(Ldz;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Ldz$4;->a:Lmw;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onMenuClick(Lmw;)V

    .line 151
    return-void
.end method
