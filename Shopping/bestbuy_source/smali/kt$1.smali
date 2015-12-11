.class Lkt$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkt;->a()V
.end annotation


# instance fields
.field final synthetic a:Lkt;


# direct methods
.method constructor <init>(Lkt;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lkt$1;->a:Lkt;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 68
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 69
    return-void
.end method
