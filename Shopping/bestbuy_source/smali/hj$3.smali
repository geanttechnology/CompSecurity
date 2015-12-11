.class Lhj$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhj;->f()V
.end annotation


# instance fields
.field final synthetic a:Lhj;


# direct methods
.method constructor <init>(Lhj;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lhj$3;->a:Lhj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lhj$3;->a:Lhj;

    invoke-static {v0}, Lhj;->e(Lhj;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 94
    return-void
.end method
