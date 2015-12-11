.class Lle$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lle;->a()V
.end annotation


# instance fields
.field final synthetic a:Lle;


# direct methods
.method constructor <init>(Lle;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lle$1;->a:Lle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 41
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 42
    return-void
.end method
