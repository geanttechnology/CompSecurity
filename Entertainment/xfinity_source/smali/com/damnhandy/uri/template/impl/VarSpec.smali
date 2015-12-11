.class public final Lcom/damnhandy/uri/template/impl/VarSpec;
.super Ljava/lang/Object;
.source "VarSpec.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/damnhandy/uri/template/impl/VarSpec$VarFormat;
    }
.end annotation


# instance fields
.field private modifier:Lcom/damnhandy/uri/template/impl/Modifier;

.field private position:Ljava/lang/Integer;

.field private value:Ljava/lang/String;

.field private variableName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/damnhandy/uri/template/impl/Modifier;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "modifier"    # Lcom/damnhandy/uri/template/impl/Modifier;

    .prologue
    .line 48
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/damnhandy/uri/template/impl/VarSpec;-><init>(Ljava/lang/String;Lcom/damnhandy/uri/template/impl/Modifier;Ljava/lang/Integer;)V

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/damnhandy/uri/template/impl/Modifier;Ljava/lang/Integer;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "modifier"    # Lcom/damnhandy/uri/template/impl/Modifier;
    .param p3, "position"    # Ljava/lang/Integer;

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    sget-object v0, Lcom/damnhandy/uri/template/impl/Modifier;->NONE:Lcom/damnhandy/uri/template/impl/Modifier;

    iput-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->position:Ljava/lang/Integer;

    .line 60
    iput-object p2, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    .line 61
    iput-object p1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->value:Ljava/lang/String;

    .line 62
    iput-object p3, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->position:Ljava/lang/Integer;

    .line 63
    invoke-direct {p0}, Lcom/damnhandy/uri/template/impl/VarSpec;->initVariableName()V

    .line 64
    return-void
.end method

.method private initVariableName()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 98
    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    sget-object v2, Lcom/damnhandy/uri/template/impl/Modifier;->NONE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-eq v1, v2, :cond_2

    .line 100
    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    sget-object v2, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    if-ne v1, v2, :cond_1

    .line 102
    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/VarSpec;->getValue()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/damnhandy/uri/template/impl/Modifier;->PREFIX:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-virtual {v2}, Lcom/damnhandy/uri/template/impl/Modifier;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "values":[Ljava/lang/String;
    aget-object v1, v0, v3

    iput-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->variableName:Ljava/lang/String;

    .line 114
    .end local v0    # "values":[Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 105
    :cond_1
    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    sget-object v2, Lcom/damnhandy/uri/template/impl/Modifier;->EXPLODE:Lcom/damnhandy/uri/template/impl/Modifier;

    if-ne v1, v2, :cond_0

    .line 107
    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/VarSpec;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/VarSpec;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->variableName:Ljava/lang/String;

    goto :goto_0

    .line 112
    :cond_2
    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/VarSpec;->getValue()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->variableName:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public getModifier()Lcom/damnhandy/uri/template/impl/Modifier;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    return-object v0
.end method

.method public getPosition()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->position:Ljava/lang/Integer;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->value:Ljava/lang/String;

    return-object v0
.end method

.method public getVariableName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->variableName:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 125
    invoke-virtual {p0}, Lcom/damnhandy/uri/template/impl/VarSpec;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 127
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->variableName:Ljava/lang/String;

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 136
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "VarSpec [modifier="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->modifier:Lcom/damnhandy/uri/template/impl/Modifier;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", value="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->value:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", position="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->position:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", variableName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/damnhandy/uri/template/impl/VarSpec;->variableName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
