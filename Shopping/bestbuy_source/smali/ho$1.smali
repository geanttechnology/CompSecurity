.class Lho$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lho;->b()V
.end annotation


# instance fields
.field final synthetic a:Lho;


# direct methods
.method constructor <init>(Lho;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lho$1;->a:Lho;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 59
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 60
    return-void
.end method
