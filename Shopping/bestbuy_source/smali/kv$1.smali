.class Lkv$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkv;->a()V
.end annotation


# instance fields
.field final synthetic a:Lkv;


# direct methods
.method constructor <init>(Lkv;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lkv$1;->a:Lkv;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 25
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 26
    return-void
.end method
