.class public final Lcom/adobe/mediacore/TextFormatBuilder;
.super Ljava/lang/Object;


# instance fields
.field private textFormat:Lcom/adobe/mediacore/TextFormatData;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/adobe/mediacore/TextFormatData;

    invoke-direct {v0}, Lcom/adobe/mediacore/TextFormatData;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/TextFormat$Font;Lcom/adobe/mediacore/TextFormat$Size;Lcom/adobe/mediacore/TextFormat$FontEdge;Lcom/adobe/mediacore/TextFormat$Color;Lcom/adobe/mediacore/TextFormat$Color;Lcom/adobe/mediacore/TextFormat$Color;Lcom/adobe/mediacore/TextFormat$Color;IIILjava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/adobe/mediacore/TextFormatData;

    invoke-direct {v0}, Lcom/adobe/mediacore/TextFormatData;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFont(Lcom/adobe/mediacore/TextFormat$Font;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p2}, Lcom/adobe/mediacore/TextFormatData;->setSize(Lcom/adobe/mediacore/TextFormat$Size;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p3}, Lcom/adobe/mediacore/TextFormatData;->setFontEdge(Lcom/adobe/mediacore/TextFormat$FontEdge;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p4}, Lcom/adobe/mediacore/TextFormatData;->setFontColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p5}, Lcom/adobe/mediacore/TextFormatData;->setBackgroundColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p6}, Lcom/adobe/mediacore/TextFormatData;->setFillColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p7}, Lcom/adobe/mediacore/TextFormatData;->setEdgeColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p8}, Lcom/adobe/mediacore/TextFormatData;->setFontOpacity(I)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p9}, Lcom/adobe/mediacore/TextFormatData;->setBackgroundOpacity(I)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p10}, Lcom/adobe/mediacore/TextFormatData;->setFillOpacity(I)V

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p11}, Lcom/adobe/mediacore/TextFormatData;->setBottomInset(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public setBackgroundColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setBackgroundColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    return-object p0
.end method

.method public setBackgroundOpacity(I)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setBackgroundOpacity(I)V

    return-object p0
.end method

.method public setBottomInset(Ljava/lang/String;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setBottomInset(Ljava/lang/String;)V

    return-object p0
.end method

.method public setEdgeColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setEdgeColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    return-object p0
.end method

.method public setFillColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFillColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    return-object p0
.end method

.method public setFillOpacity(I)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFillOpacity(I)V

    return-object p0
.end method

.method public setFont(Lcom/adobe/mediacore/TextFormat$Font;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFont(Lcom/adobe/mediacore/TextFormat$Font;)V

    return-object p0
.end method

.method public setFontColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFontColor(Lcom/adobe/mediacore/TextFormat$Color;)V

    return-object p0
.end method

.method public setFontEdge(Lcom/adobe/mediacore/TextFormat$FontEdge;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFontEdge(Lcom/adobe/mediacore/TextFormat$FontEdge;)V

    return-object p0
.end method

.method public setFontOpacity(I)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setFontOpacity(I)V

    return-object p0
.end method

.method public setSize(Lcom/adobe/mediacore/TextFormat$Size;)Lcom/adobe/mediacore/TextFormatBuilder;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TextFormatData;->setSize(Lcom/adobe/mediacore/TextFormat$Size;)V

    return-object p0
.end method

.method public toTextFormat()Lcom/adobe/mediacore/TextFormat;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TextFormatBuilder;->textFormat:Lcom/adobe/mediacore/TextFormatData;

    return-object v0
.end method
