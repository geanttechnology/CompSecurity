.class public Ltv/freewheel/hybrid/renderers/vast/model/Impression;
.super Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;
.source "Impression.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic isValid()Z
    .locals 1

    .prologue
    .line 3
    invoke-super {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->isValid()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic parse(Lorg/w3c/dom/Element;)V
    .locals 0
    .param p1, "x0"    # Lorg/w3c/dom/Element;

    .prologue
    .line 3
    invoke-super {p0, p1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->parse(Lorg/w3c/dom/Element;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 6
    const-string v0, "[Impression %s]"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-super {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractPager;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
