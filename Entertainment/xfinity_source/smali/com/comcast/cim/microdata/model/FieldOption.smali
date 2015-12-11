.class public Lcom/comcast/cim/microdata/model/FieldOption;
.super Ljava/lang/Object;
.source "FieldOption.java"


# instance fields
.field private final label:Ljava/lang/String;

.field private final order:I

.field private final value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;
    .param p3, "order"    # I

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/FieldOption;->value:Ljava/lang/String;

    .line 12
    iput-object p2, p0, Lcom/comcast/cim/microdata/model/FieldOption;->label:Ljava/lang/String;

    .line 13
    iput p3, p0, Lcom/comcast/cim/microdata/model/FieldOption;->order:I

    .line 14
    return-void
.end method


# virtual methods
.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/FieldOption;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getOrder()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/comcast/cim/microdata/model/FieldOption;->order:I

    return v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/FieldOption;->value:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 35
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 36
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "value"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/FieldOption;->value:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 37
    const-string v1, "label"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/FieldOption;->label:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 38
    const-string v1, "order"

    iget v2, p0, Lcom/comcast/cim/microdata/model/FieldOption;->order:I

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;I)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 39
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
