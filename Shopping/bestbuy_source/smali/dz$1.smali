.class Ldz$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldz;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Ldz;


# direct methods
.method constructor <init>(Ldz;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Ldz$1;->a:Ldz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 87
    new-instance v0, Lkx;

    iget-object v1, p0, Ldz$1;->a:Ldz;

    invoke-static {v1}, Ldz;->a(Ldz;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lkx;-><init>(Landroid/content/Context;)V

    .line 88
    invoke-virtual {v0}, Lkx;->show()V

    .line 89
    return-void
.end method
