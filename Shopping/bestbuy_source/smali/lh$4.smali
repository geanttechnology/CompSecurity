.class Llh$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Llh;->b()V
.end annotation


# instance fields
.field final synthetic a:Llh;


# direct methods
.method constructor <init>(Llh;)V
    .locals 0

    .prologue
    .line 285
    iput-object p1, p0, Llh$4;->a:Llh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 289
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 290
    return-void
.end method
