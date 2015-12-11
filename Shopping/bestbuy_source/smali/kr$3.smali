.class Lkr$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkr;->b()V
.end annotation


# instance fields
.field final synthetic a:Lkr;


# direct methods
.method constructor <init>(Lkr;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lkr$3;->a:Lkr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 70
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 71
    return-void
.end method
