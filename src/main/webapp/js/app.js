$(function () {
    $('#jstree').jstree({
        "plugins": [ "sort", "json_data", "contextmenu","search", "wholerow" ],
        "contextmenu":{
            "items": function($node) {
                var tree = $("#jstree").jstree(true);
                return {
                    "Create": {
                        "separator_before": false,
                        "separator_after": false,
                        "label": "Create",
                        "action": function (obj) {
                            alert("Creating");
                            var ref = $('#jstree_demo').jstree(true),
                                sel = ref.get_selected();
                            if(!sel.length) { return false; }
                            sel = sel[0];
                            sel = ref.create_node(sel, {"type":"file"});
                            if(sel) {
                                ref.edit(sel);
                            }
                            $.get("ajax",
                                {
                                    command: 'create',
                                    id: $node.id,
                                    companyName: "CompanyName",
                                    earning: "0"
                                }
                            ).done(
                                function (result) {
                                    alert(result);
                                }
                            );
                            }
                    },
                    "Rename": {
                        "separator_before": false,
                        "separator_after": false,
                        "label": "Rename",
                        "action": function (obj) {
                            $('#jstree').jstree('edit', $node);
                            $.get("ajax",
                                {
                                    command: 'rename',
                                    id: $node.id,
                                    companyName: "NewCompany"
                                }
                            ).done(
                                function (result) {
                                    alert(result);
                                }
                            );
                        }
                    },
                    "Remove": {
                        "separator_before": false,
                        "separator_after": false,
                        "label": "Remove",
                        "action": function (obj) {
                            alert("Removing");
                            $('#jstree').jstree('delete_node', $node);
                            $.get("ajax",
                                {
                                    command: 'remove',
                                    id: $node.id
                                }
                            ).done(
                                function (result) {
                                    alert(result);
                                }
                            );

                        }
                    }
                };
            }
        },
        core: {
            data: {
                url: function (node) {
                    return 'ajax';
                },
                dataType : 'json',
                data: function (node) {
                    var id = node.id === '#' ? 0 : node.id;
                    return {id: id};
                }
            },
            'check_callback' : true,
            'themes' : {
                'responsive' : false
            }
        }
    });
});









