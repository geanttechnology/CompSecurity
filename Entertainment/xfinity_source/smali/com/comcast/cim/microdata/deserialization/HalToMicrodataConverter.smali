.class public Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;
.super Ljava/lang/Object;
.source "HalToMicrodataConverter.java"

# interfaces
.implements Lcom/comcast/cim/microdata/deserialization/MicrodataDeserializer;


# instance fields
.field private final modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;)V
    .locals 0
    .param p1, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .param p2, "modelFactory"    # Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 38
    iput-object p2, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    .line 39
    return-void
.end method

.method private parseBooleanNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "linkNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "fieldName"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Z

    .prologue
    .line 251
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 252
    .local v0, "node":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v0, :cond_0

    .line 253
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asBoolean()Z

    move-result p3

    .line 255
    .end local p3    # "defaultValue":Z
    :cond_0
    return p3
.end method

.method private parseFieldOptionNode(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/FieldOption;
    .locals 5
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "fieldOptionNode"    # Lcom/fasterxml/jackson/databind/JsonNode;

    .prologue
    .line 190
    const-string v3, "label"

    invoke-direct {p0, p2, v3}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 191
    .local v1, "label":Ljava/lang/String;
    const-string v3, "order"

    const/4 v4, 0x0

    invoke-direct {p0, p2, v3, v4}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseIntNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;I)I

    move-result v2

    .line 192
    .local v2, "order":I
    new-instance v0, Lcom/comcast/cim/microdata/model/FieldOption;

    invoke-direct {v0, p1, v1, v2}, Lcom/comcast/cim/microdata/model/FieldOption;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    .line 193
    .local v0, "fieldOption":Lcom/comcast/cim/microdata/model/FieldOption;
    return-object v0
.end method

.method private parseFieldOptions(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;
    .locals 6
    .param p1, "fieldOptionsNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/FieldOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 175
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 176
    .local v2, "fieldOptions":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/FieldOption;>;"
    if-eqz p1, :cond_0

    .line 177
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->fieldNames()Ljava/util/Iterator;

    move-result-object v3

    .line 178
    .local v3, "optionValues":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 179
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 180
    .local v4, "value":Ljava/lang/String;
    invoke-virtual {p1, v4}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v1

    .line 181
    .local v1, "fieldOptionNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, v4, v1}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseFieldOptionNode(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/FieldOption;

    move-result-object v0

    .line 182
    .local v0, "fieldOption":Lcom/comcast/cim/microdata/model/FieldOption;
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 185
    .end local v0    # "fieldOption":Lcom/comcast/cim/microdata/model/FieldOption;
    .end local v1    # "fieldOptionNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v3    # "optionValues":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v4    # "value":Ljava/lang/String;
    :cond_0
    return-object v2
.end method

.method private parseForm(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataForm;
    .locals 3
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;

    .prologue
    .line 119
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JsonNode;->isArray()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 120
    check-cast p2, Lcom/fasterxml/jackson/databind/node/ArrayNode;

    .end local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseMultiValueForm(Lcom/fasterxml/jackson/databind/node/ArrayNode;)Ljava/util/List;

    move-result-object v1

    .line 121
    .local v1, "formValues":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormValue;>;"
    iget-object v2, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v2, p1, v1}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataForm(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataForm;

    move-result-object v2

    .line 124
    .end local v1    # "formValues":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormValue;>;"
    :goto_0
    return-object v2

    .line 123
    .restart local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    check-cast p2, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .end local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseSingleValueForm(Lcom/fasterxml/jackson/databind/node/ObjectNode;)Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    move-result-object v0

    .line 124
    .local v0, "formValue":Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    iget-object v2, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v2, p1, v0}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataForm(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataFormValue;)Lcom/comcast/cim/microdata/model/MicrodataForm;

    move-result-object v2

    goto :goto_0
.end method

.method private parseFormField(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField;
    .locals 11
    .param p1, "fieldNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "fieldName"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x0

    .line 154
    const-string v8, "default"

    const-string v9, ""

    invoke-direct {p0, p1, v8, v9}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 155
    .local v1, "defaultValue":Ljava/lang/String;
    const-string v8, "type"

    invoke-direct {p0, p1, v8, v10}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 156
    .local v7, "type":Ljava/lang/String;
    const-string v8, "label"

    invoke-direct {p0, p1, v8, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 157
    .local v3, "label":Ljava/lang/String;
    const-string v8, "order"

    const/4 v9, 0x0

    invoke-direct {p0, p1, v8, v9}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseIntNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;I)I

    move-result v6

    .line 158
    .local v6, "order":I
    const-string v8, "min"

    invoke-direct {p0, p1, v8, v10}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 159
    .local v5, "minimum":Ljava/lang/String;
    const-string v8, "max"

    invoke-direct {p0, p1, v8, v10}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 160
    .local v4, "maximum":Ljava/lang/String;
    const-string v8, "options"

    invoke-virtual {p1, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseFieldOptions(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;

    move-result-object v2

    .line 162
    .local v2, "fieldOptions":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/FieldOption;>;"
    new-instance v0, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    invoke-direct {v0, p2}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;-><init>(Ljava/lang/String;)V

    .line 163
    .local v0, "builder":Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;
    invoke-virtual {v0, v1}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->defaultValue(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 164
    invoke-virtual {v0, v3}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->label(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 165
    invoke-virtual {v0, v2}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->options(Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 166
    invoke-static {v7}, Lcom/comcast/cim/microdata/model/FormFieldType;->parseType(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/FormFieldType;

    move-result-object v8

    invoke-virtual {v0, v8}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->type(Lcom/comcast/cim/microdata/model/FormFieldType;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 167
    invoke-virtual {v0, v6}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->order(I)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 168
    invoke-virtual {v0, v5}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->minimum(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 169
    invoke-virtual {v0, v4}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->maximum(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;

    .line 171
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataFormField$Builder;->build()Lcom/comcast/cim/microdata/model/MicrodataFormField;

    move-result-object v8

    return-object v8
.end method

.method private parseFormFields(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;
    .locals 5
    .param p1, "fieldsNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 142
    .local v3, "fields":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormField;>;"
    if-eqz p1, :cond_0

    .line 143
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->fieldNames()Ljava/util/Iterator;

    move-result-object v2

    .line 144
    .local v2, "fieldNames":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 145
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 146
    .local v1, "fieldName":Ljava/lang/String;
    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    invoke-direct {p0, v4, v1}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseFormField(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataFormField;

    move-result-object v0

    .line 147
    .local v0, "field":Lcom/comcast/cim/microdata/model/MicrodataFormField;
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 150
    .end local v0    # "field":Lcom/comcast/cim/microdata/model/MicrodataFormField;
    .end local v1    # "fieldName":Ljava/lang/String;
    .end local v2    # "fieldNames":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    return-object v3
.end method

.method private parseForms(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;
    .locals 6
    .param p1, "root"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataForm;",
            ">;"
        }
    .end annotation

    .prologue
    .line 101
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 103
    .local v3, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    const-string v5, "_forms"

    invoke-virtual {p1, v5}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    .line 104
    .local v4, "formsRoot":Lcom/fasterxml/jackson/databind/JsonNode;
    if-nez v4, :cond_1

    .line 115
    :cond_0
    return-object v3

    .line 107
    :cond_1
    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/JsonNode;->fieldNames()Ljava/util/Iterator;

    move-result-object v1

    .line 108
    .local v1, "fieldNames":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 109
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 110
    .local v0, "fieldName":Ljava/lang/String;
    invoke-virtual {v4, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    invoke-direct {p0, v0, v5}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseForm(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataForm;

    move-result-object v2

    .line 112
    .local v2, "form":Lcom/comcast/cim/microdata/model/MicrodataForm;
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private parseIntNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;I)I
    .locals 1
    .param p1, "parentNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "fieldName"    # Ljava/lang/String;
    .param p3, "defaultValue"    # I

    .prologue
    .line 273
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 274
    .local v0, "node":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v0, :cond_0

    .line 275
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asInt()I

    move-result p3

    .line 277
    .end local p3    # "defaultValue":I
    :cond_0
    return p3
.end method

.method private parseLink(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 1
    .param p1, "relation"    # Ljava/lang/String;
    .param p2, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;

    .prologue
    .line 227
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JsonNode;->isArray()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 228
    check-cast p2, Lcom/fasterxml/jackson/databind/node/ArrayNode;

    .end local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseMultiValueLink(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ArrayNode;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v0

    .line 230
    :goto_0
    return-object v0

    .restart local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    check-cast p2, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .end local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseSingleValueLink(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ObjectNode;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v0

    goto :goto_0
.end method

.method private parseLinkValue(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    .locals 8
    .param p1, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;

    .prologue
    .line 240
    const-string v0, "href"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 241
    .local v1, "href":Ljava/lang/String;
    const-string v0, "name"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 242
    .local v2, "name":Ljava/lang/String;
    const-string v0, "title"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 243
    .local v3, "title":Ljava/lang/String;
    const-string v0, "type"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 244
    .local v5, "contentType":Ljava/lang/String;
    const-string v0, "templated"

    const/4 v7, 0x0

    invoke-direct {p0, p1, v0, v7}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseBooleanNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Z)Z

    move-result v4

    .line 246
    .local v4, "templated":Z
    iget-object v0, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface/range {v0 .. v5}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLinkValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v6

    .line 247
    .local v6, "linkValue":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    return-object v6
.end method

.method private parseLinks(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;
    .locals 6
    .param p1, "root"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataLink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 210
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 212
    .local v3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    const-string v5, "_links"

    invoke-virtual {p1, v5}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    .line 213
    .local v4, "linksRoot":Lcom/fasterxml/jackson/databind/JsonNode;
    if-nez v4, :cond_1

    .line 223
    :cond_0
    return-object v3

    .line 216
    :cond_1
    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/JsonNode;->fieldNames()Ljava/util/Iterator;

    move-result-object v1

    .line 217
    .local v1, "fieldNames":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 218
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 219
    .local v0, "fieldName":Ljava/lang/String;
    invoke-virtual {v4, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    invoke-direct {p0, v0, v5}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseLink(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v2

    .line 220
    .local v2, "link":Lcom/comcast/cim/microdata/model/MicrodataLink;
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private parseMultiValueForm(Lcom/fasterxml/jackson/databind/node/ArrayNode;)Ljava/util/List;
    .locals 5
    .param p1, "node"    # Lcom/fasterxml/jackson/databind/node/ArrayNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/node/ArrayNode;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormValue;",
            ">;"
        }
    .end annotation

    .prologue
    .line 197
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->size()I

    move-result v4

    invoke-direct {v1, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 199
    .local v1, "formList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormValue;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->size()I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 200
    invoke-virtual {p1, v3}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->get(I)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    .line 201
    .local v2, "formNode":Lcom/fasterxml/jackson/databind/JsonNode;
    check-cast v2, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .end local v2    # "formNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, v2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseSingleValueForm(Lcom/fasterxml/jackson/databind/node/ObjectNode;)Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    move-result-object v0

    .line 203
    .local v0, "form":Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 199
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 206
    .end local v0    # "form":Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    :cond_0
    return-object v1
.end method

.method private parseMultiValueLink(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ArrayNode;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 5
    .param p1, "relation"    # Ljava/lang/String;
    .param p2, "linkNodes"    # Lcom/fasterxml/jackson/databind/node/ArrayNode;

    .prologue
    .line 282
    new-instance v3, Ljava/util/ArrayList;

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->size()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 284
    .local v3, "linkValues":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLinkValue;>;"
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 285
    .local v1, "linkNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, v1}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseLinkValue(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v2

    .line 286
    .local v2, "linkValue":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 289
    .end local v1    # "linkNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v2    # "linkValue":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    :cond_0
    iget-object v4, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v4, p1, v3}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLink(Ljava/lang/String;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v4

    return-object v4
.end method

.method private parseMultivalueProperty(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ArrayNode;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 5
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "node"    # Lcom/fasterxml/jackson/databind/node/ArrayNode;
    .param p3, "embedded"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 342
    new-instance v3, Ljava/util/ArrayList;

    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->size()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 343
    .local v3, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->size()I

    move-result v4

    if-ge v0, v4, :cond_0

    .line 344
    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->get(I)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    .line 345
    .local v2, "valueNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, v2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseValue(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/lang/Object;

    move-result-object v1

    .line 346
    .local v1, "value":Ljava/lang/Object;
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 343
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 349
    .end local v1    # "value":Ljava/lang/Object;
    .end local v2    # "valueNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    iget-object v4, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v4, p1, v3, p3}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataProperty(Ljava/lang/String;Ljava/lang/Object;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v4

    return-object v4
.end method

.method private parseProperties(Lcom/fasterxml/jackson/databind/JsonNode;Z)Ljava/util/List;
    .locals 5
    .param p1, "root"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "embedded"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataProperty;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 293
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 295
    .local v2, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    if-nez p1, :cond_1

    .line 308
    :cond_0
    return-object v2

    .line 299
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->fieldNames()Ljava/util/Iterator;

    move-result-object v1

    .line 300
    .local v1, "fieldNames":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 301
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 302
    .local v0, "fieldName":Ljava/lang/String;
    const-string v4, "_"

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 303
    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    invoke-direct {p0, v0, v4, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseProperty(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v3

    .line 304
    .local v3, "property":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private parseProperty(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p3, "embedded"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 312
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/JsonNode;->isArray()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 313
    check-cast p2, Lcom/fasterxml/jackson/databind/node/ArrayNode;

    .end local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseMultivalueProperty(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ArrayNode;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    .line 315
    :goto_0
    return-object v0

    .restart local p2    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseSingleValueProperty(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    goto :goto_0
.end method

.method private parseSingleValueForm(Lcom/fasterxml/jackson/databind/node/ObjectNode;)Lcom/comcast/cim/microdata/model/MicrodataFormValue;
    .locals 6
    .param p1, "node"    # Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .prologue
    .line 129
    const-string v5, "title"

    invoke-direct {p0, p1, v5}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 130
    .local v4, "title":Ljava/lang/String;
    const-string v5, "action"

    invoke-direct {p0, p1, v5}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, "action":Ljava/lang/String;
    const-string v5, "method"

    invoke-direct {p0, p1, v5}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 132
    .local v3, "methodText":Ljava/lang/String;
    sget-object v2, Lcom/comcast/cim/microdata/http/HttpMethod;->GET:Lcom/comcast/cim/microdata/http/HttpMethod;

    .line 133
    .local v2, "method":Lcom/comcast/cim/microdata/http/HttpMethod;
    if-eqz v3, :cond_0

    .line 134
    invoke-static {v3}, Lcom/comcast/cim/microdata/http/HttpMethod;->valueOf(Ljava/lang/String;)Lcom/comcast/cim/microdata/http/HttpMethod;

    move-result-object v2

    .line 136
    :cond_0
    const-string v5, "fields"

    invoke-virtual {p1, v5}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseFormFields(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;

    move-result-object v1

    .line 137
    .local v1, "fields":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormField;>;"
    iget-object v5, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v5, v4, v0, v2, v1}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataFormValue(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/microdata/http/HttpMethod;Ljava/util/List;)Lcom/comcast/cim/microdata/model/MicrodataFormValue;

    move-result-object v5

    return-object v5
.end method

.method private parseSingleValueLink(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ObjectNode;)Lcom/comcast/cim/microdata/model/MicrodataLink;
    .locals 2
    .param p1, "relation"    # Ljava/lang/String;
    .param p2, "node"    # Lcom/fasterxml/jackson/databind/node/ObjectNode;

    .prologue
    .line 235
    invoke-direct {p0, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseLinkValue(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    .line 236
    .local v0, "linkValue":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v1, p1, v0}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataLink(Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)Lcom/comcast/cim/microdata/model/MicrodataLink;

    move-result-object v1

    return-object v1
.end method

.method private parseSingleValueProperty(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p3, "embedded"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 320
    invoke-direct {p0, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseValue(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/lang/Object;

    move-result-object v0

    .line 321
    .local v0, "value":Ljava/lang/Object;
    iget-object v1, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    invoke-interface {v1, p1, v0, p3}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataProperty(Ljava/lang/String;Ljava/lang/Object;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v1

    return-object v1
.end method

.method private parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "textNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 260
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "textNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "fieldName"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 264
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 265
    .local v0, "node":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v0, :cond_0

    .line 266
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object p3

    .line 268
    .end local p3    # "defaultValue":Ljava/lang/String;
    :cond_0
    return-object p3
.end method

.method private parseValue(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/lang/Object;
    .locals 2
    .param p1, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 325
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->isNull()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 326
    const/4 v0, 0x0

    .line 337
    :goto_0
    return-object v0

    .line 327
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->isBoolean()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 328
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->booleanValue()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0

    .line 329
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->isInt()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 330
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0

    .line 331
    :cond_2
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->isLong()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 332
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    goto :goto_0

    .line 333
    :cond_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->isObject()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 334
    invoke-virtual {p0, p1}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->convert(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    goto :goto_0

    .line 337
    :cond_4
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected convert(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 1
    .param p1, "root"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 97
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->convert(Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    return-object v0
.end method

.method protected convert(Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 8
    .param p1, "node"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p2, "isRoot"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 84
    const-string v0, "_type"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 85
    .local v1, "type":Ljava/lang/String;
    const-string v0, "_id"

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseTextNode(Lcom/fasterxml/jackson/databind/JsonNode;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 87
    .local v2, "id":Ljava/lang/String;
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseProperties(Lcom/fasterxml/jackson/databind/JsonNode;Z)Ljava/util/List;

    move-result-object v5

    .line 88
    .local v5, "properties":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    const-string v0, "_embedded"

    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    const/4 v6, 0x1

    invoke-direct {p0, v0, v6}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseProperties(Lcom/fasterxml/jackson/databind/JsonNode;Z)Ljava/util/List;

    move-result-object v7

    .line 89
    .local v7, "embedded":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataProperty;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseLinks(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;

    move-result-object v3

    .line 90
    .local v3, "links":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataLink;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->parseForms(Lcom/fasterxml/jackson/databind/JsonNode;)Ljava/util/List;

    move-result-object v4

    .line 91
    .local v4, "forms":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataForm;>;"
    invoke-interface {v5, v7}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 93
    iget-object v0, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->modelFactory:Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move v6, p2

    invoke-interface/range {v0 .. v6}, Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;->createMicrodataItem(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    return-object v0
.end method

.method public convert(Ljava/io/InputStream;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 4
    .param p1, "jsonStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 52
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v2, p1}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readTree(Ljava/io/InputStream;)Lcom/fasterxml/jackson/databind/JsonNode;
    :try_end_0
    .catch Lcom/fasterxml/jackson/core/JsonProcessingException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 58
    .local v1, "root":Lcom/fasterxml/jackson/databind/JsonNode;
    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;->convert(Lcom/fasterxml/jackson/databind/JsonNode;Z)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v2

    return-object v2

    .line 53
    .end local v1    # "root":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_0
    move-exception v0

    .line 54
    .local v0, "ex":Lcom/fasterxml/jackson/core/JsonProcessingException;
    new-instance v2, Lcom/comcast/cim/microdata/exception/MicrodataConversionException;

    const-string v3, "Cannot parse HAL JSON"

    invoke-direct {v2, v3, v0}, Lcom/comcast/cim/microdata/exception/MicrodataConversionException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 55
    .end local v0    # "ex":Lcom/fasterxml/jackson/core/JsonProcessingException;
    :catch_1
    move-exception v0

    .line 56
    .local v0, "ex":Ljava/io/IOException;
    new-instance v2, Lcom/comcast/cim/microdata/exception/MicrodataConversionException;

    const-string v3, "Cannot parse HAL JSON"

    invoke-direct {v2, v3, v0}, Lcom/comcast/cim/microdata/exception/MicrodataConversionException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method
