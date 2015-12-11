.class Lkq$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkq;->a()V
.end annotation


# instance fields
.field final synthetic a:Lkq;


# direct methods
.method constructor <init>(Lkq;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lkq$2;->a:Lkq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 42
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 43
    iget-object v0, p0, Lkq$2;->a:Lkq;

    invoke-static {v0}, Lkq;->b(Lkq;)Lno;

    move-result-object v0

    invoke-interface {v0}, Lno;->a()V

    .line 44
    return-void
.end method
