.class Lld$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lld;->a()V
.end annotation


# instance fields
.field final synthetic a:Lld;


# direct methods
.method constructor <init>(Lld;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lld$1;->a:Lld;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lld$1;->a:Lld;

    invoke-static {v0}, Lld;->a(Lld;)Lnn;

    move-result-object v0

    invoke-interface {v0}, Lnn;->a()V

    .line 29
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 30
    return-void
.end method
