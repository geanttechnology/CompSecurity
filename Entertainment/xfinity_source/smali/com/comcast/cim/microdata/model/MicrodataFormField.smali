.class public Lcom/comcast/cim/microdata/model/MicrodataFormField;
.super Ljava/lang/Object;
.source "MicrodataFormField.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/microdata/model/MicrodataFormField$1;,
        Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    }
.end annotation


# instance fields
.field private final defaultValue:Ljava/lang/String;

.field private final label:Ljava/lang/String;

.field private final maximum:Ljava/lang/String;

.field private final minimum:Ljava/lang/String;

.field private final name:Ljava/lang/String;

.field private final options:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/FieldOption;",
            ">;"
        }
    .end annotation
.end field

.field private final order:I

.field private final type:Lcom/comcast/cim/microdata/model/FormFieldType;


# direct methods
.method private constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->name:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$000(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->name:Ljava/lang/String;

    .line 22
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->label:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$100(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->label:Ljava/lang/String;

    .line 23
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->defaultValue:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$200(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->defaultValue:Ljava/lang/String;

    .line 24
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->options:Ljava/util/List;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$300(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/microdata/util/MicrodataCollectionUtils;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->options:Ljava/util/List;

    .line 25
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField;->getType(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Lcom/comcast/cim/microdata/model/FormFieldType;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->type:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 26
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->order:I
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$400(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->order:I

    .line 27
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->minimum:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$500(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->minimum:Ljava/lang/String;

    .line 28
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->maximum:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$600(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->maximum:Ljava/lang/String;

    .line 29
    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;Lcom/comcast/cim/microdata/model/MicrodataFormField$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .param p2, "x1"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$1;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField;-><init>(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)V

    return-void
.end method

.method private getType(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Lcom/comcast/cim/microdata/model/FormFieldType;
    .locals 1
    .param p1, "builder"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 32
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->type:Lcom/comcast/cim/microdata/model/FormFieldType;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$700(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Lcom/comcast/cim/microdata/model/FormFieldType;

    move-result-object v0

    if-nez v0, :cond_1

    .line 34
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->options:Ljava/util/List;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$300(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->options:Ljava/util/List;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$300(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 35
    sget-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->SELECT:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 40
    :goto_0
    return-object v0

    .line 37
    :cond_0
    sget-object v0, Lcom/comcast/cim/microdata/model/FormFieldType;->TEXT:Lcom/comcast/cim/microdata/model/FormFieldType;

    goto :goto_0

    .line 40
    :cond_1
    # getter for: Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->type:Lcom/comcast/cim/microdata/model/FormFieldType;
    invoke-static {p1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->access$700(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Lcom/comcast/cim/microdata/model/FormFieldType;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public getDefaultValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->defaultValue:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getMaximum()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->maximum:Ljava/lang/String;

    return-object v0
.end method

.method public getMinimum()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->minimum:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getOptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/FieldOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->options:Ljava/util/List;

    return-object v0
.end method

.method public getOrder()I
    .locals 1

    .prologue
    .line 65
    iget v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->order:I

    return v0
.end method

.method public getType()Lcom/comcast/cim/microdata/model/FormFieldType;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->type:Lcom/comcast/cim/microdata/model/FormFieldType;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 134
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 135
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "name"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 136
    const-string v1, "label"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->label:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 137
    const-string v1, "order"

    iget v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->order:I

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;I)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 138
    const-string v1, "defaultValue"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->defaultValue:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 139
    const-string v1, "options"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField;->options:Ljava/util/List;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 140
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
