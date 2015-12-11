.class public interface abstract Lcom/adobe/mediacore/TextFormat;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/TextFormat$Color;,
        Lcom/adobe/mediacore/TextFormat$Font;,
        Lcom/adobe/mediacore/TextFormat$FontEdge;,
        Lcom/adobe/mediacore/TextFormat$Size;
    }
.end annotation


# static fields
.field public static final DEFAULT_OPACITY:I = -0x1


# virtual methods
.method public abstract getBackgroundColor()Lcom/adobe/mediacore/TextFormat$Color;
.end method

.method public abstract getBackgroundOpacity()I
.end method

.method public abstract getBottomInset()Ljava/lang/String;
.end method

.method public abstract getEdgeColor()Lcom/adobe/mediacore/TextFormat$Color;
.end method

.method public abstract getFillColor()Lcom/adobe/mediacore/TextFormat$Color;
.end method

.method public abstract getFillOpacity()I
.end method

.method public abstract getFont()Lcom/adobe/mediacore/TextFormat$Font;
.end method

.method public abstract getFontColor()Lcom/adobe/mediacore/TextFormat$Color;
.end method

.method public abstract getFontEdge()Lcom/adobe/mediacore/TextFormat$FontEdge;
.end method

.method public abstract getFontOpacity()I
.end method

.method public abstract getSize()Lcom/adobe/mediacore/TextFormat$Size;
.end method
