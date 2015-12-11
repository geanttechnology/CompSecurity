.class Lky$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lky;->a()V
.end annotation


# instance fields
.field final synthetic a:Lky;


# direct methods
.method constructor <init>(Lky;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lky$1;->a:Lky;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 51
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 52
    return-void
.end method
