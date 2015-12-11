.class Lkq$1;
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
    .line 48
    iput-object p1, p0, Lkq$1;->a:Lkq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lkq$1;->a:Lkq;

    invoke-static {v0}, Lkq;->a(Lkq;)Lnn;

    move-result-object v0

    invoke-interface {v0}, Lnn;->a()V

    .line 52
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 53
    return-void
.end method
