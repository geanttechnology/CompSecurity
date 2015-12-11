.class Lcom/adobe/mediacore/TextFormatData;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/TextFormat;


# instance fields
.field private backgroundColor:Lcom/adobe/mediacore/TextFormat$Color;

.field private backgroundOpacity:I

.field private bottomInset:Ljava/lang/String;

.field private edgeColor:Lcom/adobe/mediacore/TextFormat$Color;

.field private fillColor:Lcom/adobe/mediacore/TextFormat$Color;

.field private fillOpacity:I

.field private font:Lcom/adobe/mediacore/TextFormat$Font;

.field private fontColor:Lcom/adobe/mediacore/TextFormat$Color;

.field private fontEdge:Lcom/adobe/mediacore/TextFormat$FontEdge;

.field private fontOpacity:I

.field private size:Lcom/adobe/mediacore/TextFormat$Size;


# direct methods
.method constructor <init>()V
    .locals 2

    const/4 v1, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->fontColor:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->backgroundColor:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->fillColor:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->edgeColor:Lcom/adobe/mediacore/TextFormat$Color;

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Size;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Size;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->size:Lcom/adobe/mediacore/TextFormat$Size;

    sget-object v0, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEFAULT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->fontEdge:Lcom/adobe/mediacore/TextFormat$FontEdge;

    sget-object v0, Lcom/adobe/mediacore/TextFormat$Font;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Font;

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->font:Lcom/adobe/mediacore/TextFormat$Font;

    iput v1, p0, Lcom/adobe/mediacore/TextFormatData;->fontOpacity:I

    iput v1, p0, Lcom/adobe/mediacore/TextFormatData;->backgroundOpacity:I

    iput v1, p0, Lcom/adobe/mediacore/TextFormatData;->fillOpacity:I

    const-string v0, "default"

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->bottomInset:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getBackgroundColor()Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->backgroundColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-object v0
.end method

.method public getBackgroundOpacity()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/TextFormatData;->backgroundOpacity:I

    return v0
.end method

.method public getBottomInset()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->bottomInset:Ljava/lang/String;

    return-object v0
.end method

.method public getEdgeColor()Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->edgeColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-object v0
.end method

.method public getFillColor()Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->fillColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-object v0
.end method

.method public getFillOpacity()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/TextFormatData;->fillOpacity:I

    return v0
.end method

.method public getFont()Lcom/adobe/mediacore/TextFormat$Font;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->font:Lcom/adobe/mediacore/TextFormat$Font;

    return-object v0
.end method

.method public getFontColor()Lcom/adobe/mediacore/TextFormat$Color;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->fontColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-object v0
.end method

.method public getFontEdge()Lcom/adobe/mediacore/TextFormat$FontEdge;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->fontEdge:Lcom/adobe/mediacore/TextFormat$FontEdge;

    return-object v0
.end method

.method public getFontOpacity()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/TextFormatData;->fontOpacity:I

    return v0
.end method

.method public getSize()Lcom/adobe/mediacore/TextFormat$Size;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatData;->size:Lcom/adobe/mediacore/TextFormat$Size;

    return-object v0
.end method

.method public setBackgroundColor(Lcom/adobe/mediacore/TextFormat$Color;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->backgroundColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-void
.end method

.method public setBackgroundOpacity(I)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/TextFormatData;->backgroundOpacity:I

    return-void
.end method

.method public setBottomInset(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->bottomInset:Ljava/lang/String;

    return-void
.end method

.method public setEdgeColor(Lcom/adobe/mediacore/TextFormat$Color;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->edgeColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-void
.end method

.method public setFillColor(Lcom/adobe/mediacore/TextFormat$Color;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->fillColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-void
.end method

.method public setFillOpacity(I)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/TextFormatData;->fillOpacity:I

    return-void
.end method

.method public setFont(Lcom/adobe/mediacore/TextFormat$Font;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->font:Lcom/adobe/mediacore/TextFormat$Font;

    return-void
.end method

.method public setFontColor(Lcom/adobe/mediacore/TextFormat$Color;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->fontColor:Lcom/adobe/mediacore/TextFormat$Color;

    return-void
.end method

.method public setFontEdge(Lcom/adobe/mediacore/TextFormat$FontEdge;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->fontEdge:Lcom/adobe/mediacore/TextFormat$FontEdge;

    return-void
.end method

.method public setFontOpacity(I)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/TextFormatData;->fontOpacity:I

    return-void
.end method

.method public setSize(Lcom/adobe/mediacore/TextFormat$Size;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TextFormatData;->size:Lcom/adobe/mediacore/TextFormat$Size;

    return-void
.end method
