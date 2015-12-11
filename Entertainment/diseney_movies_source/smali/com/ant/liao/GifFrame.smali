.class public Lcom/ant/liao/GifFrame;
.super Ljava/lang/Object;
.source "GifFrame.java"


# instance fields
.field public delay:I

.field public image:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>(Landroid/graphics/Bitmap;I)V
    .locals 0
    .param p1, "im"    # Landroid/graphics/Bitmap;
    .param p2, "del"    # I

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/ant/liao/GifFrame;->image:Landroid/graphics/Bitmap;

    .line 13
    iput p2, p0, Lcom/ant/liao/GifFrame;->delay:I

    .line 14
    return-void
.end method
