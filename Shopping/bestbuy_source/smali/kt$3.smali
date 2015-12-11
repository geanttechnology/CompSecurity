.class Lkt$3;
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
    .line 95
    iput-object p1, p0, Lkt$3;->a:Lkt;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 98
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 99
    return-void
.end method
