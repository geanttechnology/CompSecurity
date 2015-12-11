.class public final Lcom/adobe/mediacore/ABRControlParameters;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;
    }
.end annotation


# instance fields
.field private final _abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

.field private final _initialBitRate:I

.field private final _maxBitRate:I

.field private final _minBitRate:I


# direct methods
.method public constructor <init>(IIILcom/adobe/mediacore/ABRControlParameters$ABRPolicy;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/adobe/mediacore/ABRControlParameters;->_initialBitRate:I

    iput p2, p0, Lcom/adobe/mediacore/ABRControlParameters;->_minBitRate:I

    iput p3, p0, Lcom/adobe/mediacore/ABRControlParameters;->_maxBitRate:I

    iput-object p4, p0, Lcom/adobe/mediacore/ABRControlParameters;->_abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    return-void
.end method


# virtual methods
.method public getABRPolicy()Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ABRControlParameters;->_abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    return-object v0
.end method

.method public getInitialBitRate()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/ABRControlParameters;->_initialBitRate:I

    return v0
.end method

.method public getMaxBitRate()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/ABRControlParameters;->_maxBitRate:I

    return v0
.end method

.method public getMinBitRate()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/ABRControlParameters;->_minBitRate:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "Object {"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " initialBitRate="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/adobe/mediacore/ABRControlParameters;->_initialBitRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " ,minBitRate="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/adobe/mediacore/ABRControlParameters;->_minBitRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " ,maxBitRate="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/adobe/mediacore/ABRControlParameters;->_maxBitRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, " ,abrPolicy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/ABRControlParameters;->_abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    invoke-virtual {v2}, Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
