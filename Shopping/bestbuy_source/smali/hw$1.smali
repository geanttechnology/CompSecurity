.class Lhw$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhw;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhw;


# direct methods
.method constructor <init>(Lhw;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lhw$1;->a:Lhw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 75
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 76
    return-void
.end method
