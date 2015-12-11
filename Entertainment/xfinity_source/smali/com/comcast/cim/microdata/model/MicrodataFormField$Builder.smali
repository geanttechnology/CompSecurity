.class public Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
.super Ljava/lang/Object;
.source "MicrodataFormField.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/microdata/model/MicrodataFormField;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private defaultValue:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private maximum:Ljava/lang/String;

.field private minimum:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private options:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/FieldOption;",
            ">;"
        }
    .end annotation
.end field

.field private order:I

.field private type:Lcom/comcast/cim/microdata/model/FormFieldType;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->name:Ljava/lang/String;

    .line 89
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->name:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->label:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->defaultValue:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->options:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->order:I

    return v0
.end method

.method static synthetic access$500(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->minimum:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->maximum:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;)Lcom/comcast/cim/microdata/model/FormFieldType;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->type:Lcom/comcast/cim/microdata/model/FormFieldType;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/comcast/cim/microdata/model/MicrodataFormField;
    .locals 2

    .prologue
    .line 127
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataFormField;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/comcast/cim/microdata/model/MicrodataFormField;-><init>(Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;Lcom/comcast/cim/microdata/model/MicrodataFormField$1;)V

    return-object v0
.end method

.method public defaultValue(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .param p1, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->defaultValue:Ljava/lang/String;

    .line 103
    return-object p0
.end method

.method public label(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->label:Ljava/lang/String;

    .line 93
    return-object p0
.end method

.method public maximum(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .param p1, "maximum"    # Ljava/lang/String;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->maximum:Ljava/lang/String;

    .line 123
    return-object p0
.end method

.method public minimum(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .param p1, "minimum"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->minimum:Ljava/lang/String;

    .line 118
    return-object p0
.end method

.method public options(Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/FieldOption;",
            ">;)",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;"
        }
    .end annotation

    .prologue
    .line 107
    .local p1, "options":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/FieldOption;>;"
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->options:Ljava/util/List;

    .line 108
    return-object p0
.end method

.method public order(I)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .param p1, "order"    # I

    .prologue
    .line 112
    iput p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->order:I

    .line 113
    return-object p0
.end method

.method public type(Lcom/comcast/cim/microdata/model/FormFieldType;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    .locals 0
    .param p1, "type"    # Lcom/comcast/cim/microdata/model/FormFieldType;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->type:Lcom/comcast/cim/microdata/model/FormFieldType;

    .line 98
    return-object p0
.end method
