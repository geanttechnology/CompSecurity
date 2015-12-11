.class Lks$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lks;->a()V
.end annotation


# instance fields
.field final synthetic a:Lks;


# direct methods
.method constructor <init>(Lks;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lks$1;->a:Lks;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 55
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 56
    return-void
.end method
