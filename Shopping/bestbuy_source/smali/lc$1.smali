.class Llc$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Llc;->a()V
.end annotation


# instance fields
.field final synthetic a:Llc;


# direct methods
.method constructor <init>(Llc;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Llc$1;->a:Llc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Llc$1;->a:Llc;

    invoke-static {v0}, Llc;->a(Llc;)V

    .line 62
    return-void
.end method
