.class final Lng$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/squareup/picasso/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;ZLjava/lang/Object;ILandroid/widget/RelativeLayout;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Object;

.field final synthetic b:I

.field final synthetic c:Landroid/widget/RelativeLayout;


# direct methods
.method constructor <init>(Ljava/lang/Object;ILandroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lng$1;->a:Ljava/lang/Object;

    iput p2, p0, Lng$1;->b:I

    iput-object p3, p0, Lng$1;->c:Landroid/widget/RelativeLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError()V
    .locals 0

    .prologue
    .line 55
    return-void
.end method

.method public onSuccess()V
    .locals 3

    .prologue
    .line 48
    iget-object v0, p0, Lng$1;->a:Ljava/lang/Object;

    check-cast v0, Lnh;

    iget v1, p0, Lng$1;->b:I

    iget-object v2, p0, Lng$1;->c:Landroid/widget/RelativeLayout;

    invoke-interface {v0, v1, v2}, Lnh;->a(ILandroid/widget/RelativeLayout;)V

    .line 49
    return-void
.end method
